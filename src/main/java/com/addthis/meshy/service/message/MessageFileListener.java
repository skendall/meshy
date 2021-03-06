/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.addthis.meshy.service.message;

import java.util.Map;

import com.addthis.basis.util.JitterClock;

import com.addthis.meshy.VirtualFileInput;

class MessageFileListener extends MessageFile {

    final TopicSender target;
    private final String path;

    MessageFileListener(String name, String fullPath, TopicSender target) {
        super(name, JitterClock.globalTime(), 0);
        this.target = target;
        this.path = fullPath;
    }

    @Override
    public VirtualFileInput getInput(Map<String, String> options) {
        return new MessageFileInput(path, options, target);
    }
}
