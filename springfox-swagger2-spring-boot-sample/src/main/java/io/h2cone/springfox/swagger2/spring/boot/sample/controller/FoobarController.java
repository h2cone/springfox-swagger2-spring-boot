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

package io.h2cone.springfox.swagger2.spring.boot.sample.controller;

import io.h2cone.springfox.swagger2.spring.boot.sample.model.Foobar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "this is foobar controller")
@RestController
@RequestMapping("/foobar")
public class FoobarController {

    @ApiOperation("post method")
    /**/
    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody Foobar foobar) {
        return ResponseEntity.ok("");
    }

    @ApiOperation("get method")
    @ApiImplicitParam(name = "id", value = "foobar id", required = true)
    /**/
    @GetMapping("/get")
    public ResponseEntity<Foobar> get(@RequestParam Long id) {
        Foobar foobar = new Foobar()
                .setId(id)
                .setName("");
        return ResponseEntity.ok(foobar);
    }
}
