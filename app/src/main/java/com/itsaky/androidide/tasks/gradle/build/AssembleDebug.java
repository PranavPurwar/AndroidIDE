/*
 * This file is part of AndroidIDE.
 *
 * AndroidIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AndroidIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.itsaky.androidide.tasks.gradle.build;

import com.itsaky.androidide.R;
import com.itsaky.androidide.app.StudioApp;
import com.itsaky.androidide.services.builder.IDEService;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AssembleDebug extends ApkGeneratingTask {

    @Override
    public String getName() {
        return StudioApp.getInstance().getString(R.string.build_debug);
    }

    @Override
    protected Set<File> provideApkDirectories(File buildDir) {
        final Set<File> dirs = new HashSet<>();
        dirs.add(new File(buildDir, "outputs/apk/debug"));
        return dirs;
    }

    @Override
    public String getCommands() {
        return "assembleDebug";
    }

    @Override
    public List<String> getTasks() {
        return Collections.singletonList(getCommands());
    }

    @Override
    public int getTaskID() {
        return IDEService.TASK_ASSEMBLE_DEBUG;
    }

    @Override
    public boolean canOutput() {
        return true;
    }

    @Override
    public Type getType() {
        return Type.BUILD;
    }
}
