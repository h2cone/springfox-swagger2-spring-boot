/*
 * Copyright 2020 hehuang tw8ape@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.h2cone.springfox.swagger2.spring.boot.autoconfigure;

import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@ConditionalOnProperty(prefix = "springfox-swagger2", name = "enabled")
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SpringFoxSwagger2Prop.class)
public class SpringFoxSwagger2AutoConfig {
    @Resource
    private SpringFoxSwagger2Prop springFoxSwagger2Prop;

    @Bean
    @ConditionalOnMissingBean
    public Docket docket() {
        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select();
        List<String> excludedPaths = springFoxSwagger2Prop.getExcludedPaths();
        if (excludedPaths == null || excludedPaths.isEmpty()) {
            builder.paths(Predicates.not(PathSelectors.regex("/error")))
                    .paths(Predicates.not(PathSelectors.regex("/actuator.*")));
        } else {
            for (String path : excludedPaths) {
                builder.paths(Predicates.not(PathSelectors.regex(path)));
            }
        }
        return builder.build();
    }

    private ApiInfo apiInfo() {
        SpringFoxSwagger2Prop.ApiInfo apiInfo = springFoxSwagger2Prop.getApiInfo();
        if (apiInfo == null) {
            return ApiInfo.DEFAULT;
        }
        SpringFoxSwagger2Prop.Contact contact = apiInfo.getContact();
        return new ApiInfo(
                apiInfo.getTitle(),
                apiInfo.getDescription(),
                apiInfo.getVersion(),
                apiInfo.getTermsOfServiceUrl(),
                new Contact(contact.getName(), contact.getUrl(), contact.getEmail()),
                apiInfo.getLicense(),
                apiInfo.getLicenseUrl(),
                Collections.emptyList()
        );
    }
}
