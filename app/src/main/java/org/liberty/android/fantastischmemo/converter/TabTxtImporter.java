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

package org.liberty.android.fantastischmemo.converter;

import org.liberty.android.fantastischmemo.utils.DatabaseUtil;

import javax.inject.Inject;

public class TabTxtImporter extends CSVImporter {

    private static final long serialVersionUID = 3482178789406005987L;

    @Inject
    public TabTxtImporter(DatabaseUtil databaseUtil) {
        super(databaseUtil);
        setSeparator('\t');
    }

    @Override
    public String getSrcExtension() {
        return "txt";
    }
}
