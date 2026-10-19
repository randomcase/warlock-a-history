package com.sovereign.warlock.config;

import com.sovereign.warlock.domain.MysticalPillar;
import com.sovereign.warlock.domain.WarlockColorOrder;
import com.sovereign.warlock.domain.WarlockOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Spring Boot @Configuration defining the 7 @Profile-scoped Abrahamic Warlock Beans
 * ordered strictly by Color (1..7).
 */
@Configuration("sevenWarlockProfileConfig")
public class SevenWarlockProfileConfig {

    private final Path resourcesDir;

    public SevenWarlockProfileConfig() {
        this(Path.of("src", "main", "resources"));
    }

    public SevenWarlockProfileConfig(Path resourcesDir) {
        this.resourcesDir = resourcesDir;
    }

    @Bean(name = "warlockOrder1WhiteFire")
    @Profile("warlock-1-white")
    public WarlockOrder warlockOrder1WhiteFire() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-1-white");
        return new WarlockOrder.WhiteFireWarlock(
                WarlockColorOrder.ORDER_1_WHITE_FIRE,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                30
        );
    }

    @Bean(name = "warlockOrder2BlackFire")
    @Profile("warlock-2-black")
    public WarlockOrder warlockOrder2BlackFire() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-2-black");
        return new WarlockOrder.BlackFireWarlock(
                WarlockColorOrder.ORDER_2_BLACK_FIRE,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                231
        );
    }

    @Bean(name = "warlockOrder3SapphireMerkabah")
    @Profile("warlock-3-sapphire")
    public WarlockOrder warlockOrder3SapphireMerkabah() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-3-sapphire");
        return new WarlockOrder.SapphireMerkabahWarlock(
                WarlockColorOrder.ORDER_3_TEKHELET_SAPPHIRE,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                7
        );
    }

    @Bean(name = "warlockOrder4GoldAlast")
    @Profile("warlock-4-gold")
    public WarlockOrder warlockOrder4GoldAlast() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-4-gold");
        return new WarlockOrder.GoldAlastWarlock(
                WarlockColorOrder.ORDER_4_HASHMAL_GOLD,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                72
        );
    }

    @Bean(name = "warlockOrder5CrimsonSeraph")
    @Profile("warlock-5-crimson")
    public WarlockOrder warlockOrder5CrimsonSeraph() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-5-crimson");
        return new WarlockOrder.CrimsonSeraphWarlock(
                WarlockColorOrder.ORDER_5_GEVURAH_CRIMSON,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                6
        );
    }

    @Bean(name = "warlockOrder6BrassGoetic")
    @Profile("warlock-6-brass")
    public WarlockOrder warlockOrder6BrassGoetic() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-6-brass");
        return new WarlockOrder.BrassGoeticWarlock(
                WarlockColorOrder.ORDER_6_GOETIC_BRASS,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                72
        );
    }

    @Bean(name = "warlockOrder7EmeraldTwilight")
    @Profile("warlock-7-emerald")
    public WarlockOrder warlockOrder7EmeraldTwilight() {
        WarlockProfileProperties props = YamlProfileLoader.loadProfile(resourcesDir, "warlock-7-emerald");
        return new WarlockOrder.EmeraldTwilightWarlock(
                WarlockColorOrder.ORDER_7_EMERALD_TWILIGHT,
                props,
                MysticalPillar.valueOf(props.primaryPillar()),
                99
        );
    }

    /**
     * Discovers and instantiates @Bean methods whose @Profile matches activeProfiles,
     * sorted deterministically by Color Order (1..7).
     */
    public List<WarlockOrder> loadActiveProfileBeans(Set<String> activeProfiles) {
        List<WarlockOrder> activeOrders = new ArrayList<>();
        for (Method method : SevenWarlockProfileConfig.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Bean.class) && method.isAnnotationPresent(Profile.class)) {
                Profile profileAnnotation = method.getAnnotation(Profile.class);
                boolean matches = Arrays.stream(profileAnnotation.value())
                        .anyMatch(activeProfiles::contains);
                if (matches) {
                    try {
                        WarlockOrder order = (WarlockOrder) method.invoke(this);
                        activeOrders.add(order);
                    } catch (ReflectiveOperationException e) {
                        throw new IllegalStateException("Failed to initialize @Profile bean: " + method.getName(), e);
                    }
                }
            }
        }
        return activeOrders.stream()
                .sorted(Comparator.comparing(WarlockOrder::colorOrder, WarlockColorOrder.BY_COLOR_ORDER_7))
                .toList();
    }
}
