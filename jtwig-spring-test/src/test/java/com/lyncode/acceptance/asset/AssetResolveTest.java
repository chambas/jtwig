/**
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

package com.lyncode.acceptance.asset;

import com.lyncode.acceptance.AbstractViewTest;
import com.lyncode.jtwig.mvc.JtwigViewResolver;
import com.lyncode.jtwig.services.api.ModelMapFiller;
import org.hamcrest.Matcher;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;

public class AssetResolveTest extends AbstractViewTest {
    @Autowired
    private JtwigViewResolver jtwigViewResolver;

    @Override
    protected void given(ModelMapFiller modelMap) {
        // Nothing
    }

    @Override
    protected String forView() {
        return "asset/resolve";
    }

    @Override
    protected Matcher<? super String> contentMatcher() {
        return is("/public/"+jtwigViewResolver.getTheme()+"/test");
    }
}
