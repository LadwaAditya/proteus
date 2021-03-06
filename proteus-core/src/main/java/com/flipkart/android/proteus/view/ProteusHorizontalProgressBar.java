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

package com.flipkart.android.proteus.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.flipkart.android.proteus.ProteusView;

/**
 * HorizontalProgressBar
 *
 * @author aditya.sharat
 */
public class ProteusHorizontalProgressBar extends com.flipkart.android.proteus.view.custom.HorizontalProgressBar implements ProteusView {

    private Manager viewManager;

    @Nullable
    private Object extras;

    public ProteusHorizontalProgressBar(Context context) {
        super(context);
    }

    @Override
    public Manager getViewManager() {
        return viewManager;
    }

    @Override
    public void setViewManager(@NonNull Manager manager) {
        this.viewManager = manager;
    }

    @Override
    public void setExtras(@Nullable Object extras) {
        this.extras = extras;
    }

    @Nullable
    @Override
    public Object getExtras() {
        return extras;
    }

    @NonNull
    @Override
    public View getAsView() {
        return this;
    }
}
