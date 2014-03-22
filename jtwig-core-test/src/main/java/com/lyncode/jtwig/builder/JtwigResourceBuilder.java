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

package com.lyncode.jtwig.builder;

import com.lyncode.builder.Builder;
import com.lyncode.jtwig.exception.ResourceException;
import com.lyncode.jtwig.resource.JtwigResource;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JtwigResourceBuilder implements Builder<JtwigResource> {
    private JtwigResource resource = mock(JtwigResource.class);

    public JtwigResourceBuilder withContent (String content) {
        try {
            when(resource.retrieve()).thenReturn(new ByteArrayInputStream(content.getBytes()));
        } catch (ResourceException e) {
            // Nothing
        }
        return this;
    }

    public JtwigResourceBuilder withRelative (String path, JtwigResourceBuilder builder) {
        try {
            when(resource.resolve(path)).thenReturn(builder.build());
        } catch (ResourceException e) {

        }
        return this;
    }

    @Override
    public JtwigResource build() {
        return resource;
    }
}
