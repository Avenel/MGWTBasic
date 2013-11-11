/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace.HomePlaceTokenizer;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailPlace.NewsDetailPlaceTokenizer;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace.NewsPlaceTokenizer;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentPlace;

/**
 * Place History Mapper. Mapps History<->Place.
 * @author Daniel Kurka
 * 
 */
@WithTokenizers({ HomePlaceTokenizer.class, NewsPlaceTokenizer.class, NewsDetailPlace.NewsDetailPlaceTokenizer.class, StudentPlace.StudentPlaceTokenizer.class, 
					LecturePlace.LecturePlaceTokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
