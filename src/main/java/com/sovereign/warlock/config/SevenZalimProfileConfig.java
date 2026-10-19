package com.sovereign.warlock.config;

import com.sovereign.warlock.domain.WrongdoerArchetypeOrder;
import com.sovereign.warlock.domain.WrongdoerArchetypeOrder.WrongdoerWarlockProfile;
import com.sovereign.warlock.domain.WrongdoerArchetypeOrder.ZalimProfileProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Spring Boot @Configuration defining the 7 @Profile-scoped Wrongdoer (Az-Zalimun)
 * Warlock Profiles (zalim-1-fasad .. zalim-7-zulm) that canonically represent
 * Islamic principles of disorder (Fasad), immodesty (Fahishah/Tabarruj), and
 * challenge to the formation of monotheistic hegemony under Abraham (Qur'an 2:124).
 */
@Configuration("sevenZalimProfileConfig")
public class SevenZalimProfileConfig {

    private final Path resourcesDir;

    public SevenZalimProfileConfig() {
        this(Path.of("src", "main", "resources"));
    }

    public SevenZalimProfileConfig(Path resourcesDir) {
        this.resourcesDir = resourcesDir;
    }

    @Bean(name = "zalimProfile1Fasad")
    @Profile("zalim-1-fasad")
    public WrongdoerWarlockProfile zalimProfile1Fasad() {
        return verifyAndResolve("zalim-1-fasad");
    }

    @Bean(name = "zalimProfile2Fahishah")
    @Profile("zalim-2-fahishah")
    public WrongdoerWarlockProfile zalimProfile2Fahishah() {
        return verifyAndResolve("zalim-2-fahishah");
    }

    @Bean(name = "zalimProfile3Baghy")
    @Profile("zalim-3-baghy")
    public WrongdoerWarlockProfile zalimProfile3Baghy() {
        return verifyAndResolve("zalim-3-baghy");
    }

    @Bean(name = "zalimProfile4Fitnah")
    @Profile("zalim-4-fitnah")
    public WrongdoerWarlockProfile zalimProfile4Fitnah() {
        return verifyAndResolve("zalim-4-fitnah");
    }

    @Bean(name = "zalimProfile5Hawa")
    @Profile("zalim-5-hawa")
    public WrongdoerWarlockProfile zalimProfile5Hawa() {
        return verifyAndResolve("zalim-5-hawa");
    }

    @Bean(name = "zalimProfile6Jibt")
    @Profile("zalim-6-jibt")
    public WrongdoerWarlockProfile zalimProfile6Jibt() {
        return verifyAndResolve("zalim-6-jibt");
    }

    @Bean(name = "zalimProfile7Zulm")
    @Profile("zalim-7-zulm")
    public WrongdoerWarlockProfile zalimProfile7Zulm() {
        return verifyAndResolve("zalim-7-zulm");
    }

    private WrongdoerWarlockProfile verifyAndResolve(String profileId) {
        ZalimProfileProperties props = YamlProfileLoader.loadZalimProfile(resourcesDir, profileId);
        WrongdoerWarlockProfile canonical = WrongdoerArchetypeOrder.forProfileId(props.profileId());
        if (props.zalimIndex() != canonical.zalimIndex()) {
            throw new IllegalStateException("Zalim YAML index mismatch for " + profileId);
        }
        return canonical;
    }

    public List<WrongdoerWarlockProfile> loadActiveZalimBeans(Set<String> activeProfiles) {
        List<WrongdoerWarlockProfile> list = new ArrayList<>();
        for (Method method : SevenZalimProfileConfig.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Bean.class) && method.isAnnotationPresent(Profile.class)) {
                Profile profileAnnotation = method.getAnnotation(Profile.class);
                boolean matches = Arrays.stream(profileAnnotation.value())
                        .anyMatch(activeProfiles::contains);
                if (matches) {
                    try {
                        WrongdoerWarlockProfile bean = (WrongdoerWarlockProfile) method.invoke(this);
                        list.add(bean);
                    } catch (ReflectiveOperationException e) {
                        throw new IllegalStateException("Failed to initialize @Profile Zalim bean: " + method.getName(), e);
                    }
                }
            }
        }
        return list.stream()
                .sorted(WrongdoerArchetypeOrder.BY_ZALIM_INDEX)
                .toList();
    }
}
