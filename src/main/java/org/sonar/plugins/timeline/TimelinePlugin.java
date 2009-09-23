/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2009 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.timeline;

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.Plugin;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.plugins.timeline.client.GwtTimeline;

@Properties({
  @Property(
      key = GwtTimeline.HEIGHT_PROP,
      name = "Timeline height",
      description = "The timeline height in pixels",
      defaultValue = GwtTimeline.DEFAULT_HEIGHT)
})
public class TimelinePlugin implements Plugin {

  public String getKey() {
    return "gwt-timeline";
  }

  public String getName() {
    return "Timeline";
  }

  public String getDescription() {
    return "GWT metrics history timeline plugin";
  }

  public List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> extensions = new ArrayList<Class<? extends Extension>>();
    extensions.add(GwtTimelinePage.class);
    extensions.add(RubyTimelineWebService.class);
    return extensions;
  }

  @Override
  public String toString() {
    return getKey();
  }
}