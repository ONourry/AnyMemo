/*
Copyright (C) 2013 Haowen Ning

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

*/
package org.liberty.android.fantastischmemo.ui.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.liberty.android.fantastischmemo.common.AnyMemoDBOpenHelper;
import org.liberty.android.fantastischmemo.common.AnyMemoDBOpenHelperManager;

public abstract class DBLoader<T> extends AsyncTaskLoader<T> {

    protected String dbPath;

    protected AnyMemoDBOpenHelper dbOpenHelper;

    protected abstract T dbLoadInBackground();

    public DBLoader(Context context, String dbPath) {
        super(context);
        this.dbPath = dbPath;
    }

    @Override
    public T loadInBackground() {
        dbOpenHelper = AnyMemoDBOpenHelperManager.getHelper(getContext(),
                dbPath);
        try {
            return dbLoadInBackground();
        } finally {
            AnyMemoDBOpenHelperManager.releaseHelper(dbOpenHelper);
        }
    }
}
