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

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringFoxSwagger2AutoConfig.class})
@TestPropertySource(properties = {
        "springfox-swagger2.enabled=true",
        "springfox-swagger2.api-info.title=example",
        "springfox-swagger2.api-info.description=foobar",
        "springfox-swagger2.api-info.version=0.0.1",
        "springfox-swagger2.api-info.termsOfServiceUrl=https://www.google.com",
        "springfox-swagger2.api-info.contact.name=Lily",
        "springfox-swagger2.api-info.contact.url=https://www.v2ex.com",
        "springfox-swagger2.api-info.contact.email=example@gmail.com",
        "springfox-swagger2.api-info.license=Apache-2.0",
        "springfox-swagger2.api-info.licenseUrl=https://www.apache.org/licenses/LICENSE-2.0",

        "springfox-swagger2.excludedPaths[0]=/error",
        "springfox-swagger2.excludedPaths[1]=/actuator.*",
})
public class SpringFoxSwagger2AutoConfigTest {
    @Resource
    private SpringFoxSwagger2Prop springFoxSwagger2Prop;

    @Test
    public void properties() {
        SpringFoxSwagger2Prop.ApiInfo apiInfo = springFoxSwagger2Prop.getApiInfo();
        Assert.assertEquals("example", apiInfo.getTitle());
        Assert.assertEquals("foobar", apiInfo.getDescription());
        Assert.assertEquals("0.0.1", apiInfo.getVersion());
        Assert.assertEquals("https://www.google.com", apiInfo.getTermsOfServiceUrl());
        Assert.assertEquals("Lily", apiInfo.getContact().getName());
        Assert.assertEquals("https://www.v2ex.com", apiInfo.getContact().getUrl());
        Assert.assertEquals("example@gmail.com", apiInfo.getContact().getEmail());
        Assert.assertEquals("Apache-2.0", apiInfo.getLicense());
        Assert.assertEquals("https://www.apache.org/licenses/LICENSE-2.0", apiInfo.getLicenseUrl());

        List<String> excludedPaths = springFoxSwagger2Prop.getExcludedPaths();
        Assert.assertEquals("/error", excludedPaths.get(0));
        Assert.assertEquals("/actuator.*", excludedPaths.get(1));
    }
}