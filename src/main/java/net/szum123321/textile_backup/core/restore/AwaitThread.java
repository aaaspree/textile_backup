/*
 * A simple backup mod for Fabric
 * Copyright (C) 2020  Szum123321
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.szum123321.textile_backup.core.restore;

import net.szum123321.textile_backup.Statics;

/*
    This thread waits some amount of time and then starts a new, independent thread
*/
public class AwaitThread extends Thread {
    private final int delay;
    private final Runnable taskRunnable;

    public AwaitThread(int delay, Runnable taskRunnable) {
        this.delay = delay;
        this.taskRunnable = taskRunnable;
    }

    @Override
    public void run() {
        Statics.LOGGER.info("Countdown begins... Waiting {} second.", delay);

        // 𝄞 This is final count down! Tu ruru Tu, Tu Ru Tu Tu ♪
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            Statics.LOGGER.info("Backup restoration cancelled.");
            return;
        }

        /*
            We're leaving together,
            But still it's farewell
            And maybe we'll come back
         */
        new Thread(taskRunnable).start();
    }
}
