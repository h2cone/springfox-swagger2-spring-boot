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

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("springfox-swagger2")
public class SpringFoxSwagger2Prop {
    private ApiInfo apiInfo;

    private List<String> excludedPaths;

    static class ApiInfo {
        private String title = springfox.documentation.service.ApiInfo.DEFAULT.getTitle();

        private String description = springfox.documentation.service.ApiInfo.DEFAULT.getDescription();

        private String version = springfox.documentation.service.ApiInfo.DEFAULT.getVersion();

        private String termsOfServiceUrl = springfox.documentation.service.ApiInfo.DEFAULT.getTermsOfServiceUrl();

        private Contact contact;

        private String license = springfox.documentation.service.ApiInfo.DEFAULT.getLicense();

        private String licenseUrl = springfox.documentation.service.ApiInfo.DEFAULT.getLicenseUrl();

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }
    }

    static class Contact {
        private String name = springfox.documentation.service.ApiInfo.DEFAULT_CONTACT.getName();

        private String url = springfox.documentation.service.ApiInfo.DEFAULT_CONTACT.getUrl();

        private String email = springfox.documentation.service.ApiInfo.DEFAULT_CONTACT.getEmail();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    public List<String> getExcludedPaths() {
        return excludedPaths;
    }

    public void setExcludedPaths(List<String> excludedPaths) {
        this.excludedPaths = excludedPaths;
    }
}
