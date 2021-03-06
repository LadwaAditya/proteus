/*
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION
 *
 * Copyright (c) 2017 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.flipkart.android.proteus;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.flipkart.android.proteus.value.DrawableValue;
import com.flipkart.android.proteus.value.Layout;
import com.flipkart.android.proteus.value.ObjectValue;
import com.flipkart.android.proteus.value.Value;

/**
 * @author kirankumar
 * @author adityasharat
 */
public interface ProteusLayoutInflater {

    /**
     * This methods builds a {@link ProteusView}
     *
     * @param layout    The {@link Layout} which defines the layout for the {@link View} to be built.
     * @param data      The {@link ObjectValue} which will be used to replace bindings with values in the {@link View}.
     * @param parent    The intended parent view for the {@link View} that will be built.
     * @param dataIndex The index of this view in its parent. Pass 0 if it has no parent.
     * @return An native android view
     */
    @NonNull
    ProteusView inflate(@NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex);

    /**
     * This methods builds a {@link ProteusView}
     *
     * @param layout    The {@link Layout} which defines the layout for the {@link View} to be built.
     * @param data      The {@link ObjectValue} which will be used to replace bindings with values in the {@link View}.
     * @param dataIndex The index of this view in its parent. Pass 0 if it has no parent.
     * @return An native android view
     */
    @NonNull
    ProteusView inflate(@NonNull Layout layout, @NonNull ObjectValue data, int dataIndex);

    /**
     * This methods inflates a {@link ProteusView}
     *
     * @param layout The {@link Layout} which defines the layout for the {@link View} to be built.
     * @param data   The {@link ObjectValue} which will be used to replace bindings with values in the {@link View}.
     * @return An native android view
     */
    @NonNull
    ProteusView inflate(@NonNull Layout layout, @NonNull ObjectValue data);

    /**
     * @param name
     * @param data
     * @param parent
     * @param dataIndex
     * @return
     */
    @NonNull
    ProteusView inflate(@NonNull String name, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex);

    /**
     * @param name
     * @param data
     * @param dataIndex
     * @return
     */
    @NonNull
    ProteusView inflate(@NonNull String name, @NonNull ObjectValue data, int dataIndex);

    /**
     * @param name
     * @param data
     * @return
     */
    @NonNull
    ProteusView inflate(@NonNull String name, @NonNull ObjectValue data);

    /**
     * Returns the {@link ViewTypeParser} for the specified view type.
     *
     * @param type The name of the view type.
     * @return The {@link ViewTypeParser} associated to the specified view type
     */
    @Nullable
    ViewTypeParser getParser(@NonNull String type);

    /**
     * Give the View ID for this string. This will generally be given by the instance of ID Generator
     * which will be available with the Layout Builder.
     * This is similar to R.id auto generated
     *
     * @return int value for this id. This will never be -1.
     */
    int getUniqueViewId(@NonNull String id);

    /**
     * All consumers of this should ensure that they save the instance state of the ID generator along with the activity/
     * fragment and resume it when the Layout Builder is being re-initialized
     *
     * @return Returns the Id Generator for this Layout Builder
     */
    @NonNull
    IdGenerator getIdGenerator();

    /**
     * The Layout Inflaters callback interface
     */
    interface Callback {

        /**
         * called when the builder encounters a view type which it cannot understand.
         */
        @NonNull
        ProteusView onUnknownViewType(ProteusContext context, String type, Layout layout, ObjectValue data, int index);

        /**
         * called when any click occurs on views
         *
         * @param event The Event type
         * @param value Value set to the event attribute
         * @param view  The view that triggered the event
         */
        void onEvent(String event, Value value, ProteusView view);

    }

    /**
     * Used for loading drawables/images/bitmaps asynchronously
     */
    interface ImageLoader {
        /**
         * Useful for asynchronous download of bitmap.
         *
         * @param url      the url for the drawable/bitmap/image
         * @param callback the callback to set the drawable/bitmap
         */
        void getBitmap(ProteusView view, String url, DrawableValue.AsyncCallback callback);
    }
}
