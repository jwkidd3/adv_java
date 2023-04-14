package labs.solutions.osgi;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: kelby
 * Date: 8/15/12
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
final class PingerEntry {
  HttpPinger pinger;
  int id;
  Future future;

  PingerEntry(HttpPinger pinger, int id, Future future) {
    this.pinger = pinger;
    this.id = id;
    this.future = future;
  }
}
