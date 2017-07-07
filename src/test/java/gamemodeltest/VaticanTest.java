package gamemodeltest;

import org.junit.Before;
import org.junit.Test;

import gamemodel.Model;
import gamemodel.Player;
import gamemodel.Point;
import gamemodel.Team;

public class VaticanTest {
	Player p;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		Model m = new Model(4);
		p = m.getPlayer(Team.RED);
	}

	@Test
	public void pointsOkNoSupport() {
		p.addPoint(new Point(0, 100, 0));
		p.vaticanReport(0);
	}

	@Test
	public void pointsOkSupport() {
		p.addPoint(new Point(0, 100, 0));
		p.vaticanReport(1);
	}

	@Test
	public void noPointsNoSupport() {
		p.vaticanReport(1);
	}
}
