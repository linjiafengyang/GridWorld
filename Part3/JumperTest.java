import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import sun.net.www.content.audio.wav;

public class JumperTest {
	ActorWorld world = new ActorWorld();
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testBasicDemand() {
		
		Jumper aJumper = new Jumper(Color.RED);
		Jumper bJumper = new Jumper(Color.ORANGE);
		Jumper cJumper = new Jumper(Color.BLUE);
		
		world.add(new Location(2, 0), aJumper);
		aJumper.act();
		assertEquals(0, aJumper.getLocation().getRow());
		assertEquals(0, aJumper.getLocation().getCol());
		assertEquals(Location.NORTH, aJumper.getDirection());
		
		world.add(new Location(1, 3), bJumper);
		bJumper.act();
		assertEquals(0, bJumper.getLocation().getRow());
		assertEquals(3, bJumper.getLocation().getCol());
		assertEquals(Location.NORTH, bJumper.getDirection());
		bJumper.act();
		assertEquals(0, bJumper.getLocation().getRow());
		assertEquals(3, bJumper.getLocation().getCol());
		assertEquals(Location.NORTHEAST, bJumper.getDirection());
		bJumper.act();
		assertEquals(0, bJumper.getLocation().getRow());
		assertEquals(3, bJumper.getLocation().getCol());
		assertEquals(Location.EAST, bJumper.getDirection());
		bJumper.act();
		assertEquals(0, bJumper.getLocation().getRow());
		assertEquals(5, bJumper.getLocation().getCol());
		assertEquals(Location.EAST, bJumper.getDirection());
		
		world.add(new Location(0, 6), cJumper);
		cJumper.act();
		assertEquals(0, cJumper.getLocation().getRow());
		assertEquals(6, cJumper.getLocation().getCol());
		assertEquals(Location.NORTHEAST, cJumper.getDirection());
		cJumper.act();
		assertEquals(0, cJumper.getLocation().getRow());
		assertEquals(6, cJumper.getLocation().getCol());
		assertEquals(Location.EAST, cJumper.getDirection());
		cJumper.act();
		assertEquals(0, cJumper.getLocation().getRow());
		assertEquals(8, cJumper.getLocation().getCol());
		assertEquals(Location.EAST, cJumper.getDirection());
	}
	@Test
	public void testActor() {
		Jumper dJumper = new Jumper(Color.ORANGE);
		Jumper eJumper = new Jumper(Color.PINK);
		Rock rock = new Rock(Color.BLACK);
		Flower flower = new Flower(Color.RED);
		Bug bug = new Bug(Color.GRAY);
		
		// jump over rock
		world.add(new Location(3, 3), dJumper);
		world.add(new Location(2, 3), rock);
		dJumper.act();
		assertEquals(1, dJumper.getLocation().getRow());
		assertEquals(3, dJumper.getLocation().getCol());
		assertEquals(Location.NORTH, dJumper.getDirection());
		
		// not jump, but move
		dJumper.moveTo(new Location(5, 5));
		rock.moveTo(new Location(3, 5));
		dJumper.act();
		assertEquals(4, dJumper.getLocation().getRow());
		assertEquals(5, dJumper.getLocation().getCol());
		assertEquals(Location.NORTH, dJumper.getDirection());
		
		// not jump, but move
		dJumper.moveTo(new Location(6, 6));
		world.add(new Location(4, 6), flower);
		dJumper.act();
		assertEquals(5, dJumper.getLocation().getRow());
		assertEquals(6, dJumper.getLocation().getCol());
		assertEquals(Location.NORTH, dJumper.getDirection());
		
		// jump over flower
		dJumper.moveTo(new Location(3, 3));
		flower.moveTo(new Location(2, 3));
		dJumper.act();
		assertEquals(1, dJumper.getLocation().getRow());
		assertEquals(3, dJumper.getLocation().getCol());
		assertEquals(Location.NORTH, dJumper.getDirection());
		
		// two Jumpers face north, the upper one jump first
		dJumper.moveTo(new Location(5, 5));
		world.add(new Location(3, 5), eJumper);
		eJumper.act();
		dJumper.act();
		assertEquals(1, eJumper.getLocation().getRow());
		assertEquals(5, eJumper.getLocation().getCol());
		assertEquals(Location.NORTH, eJumper.getDirection());
		assertEquals(3, dJumper.getLocation().getRow());
		assertEquals(5, dJumper.getLocation().getCol());
		assertEquals(Location.NORTH, dJumper.getDirection());
		
		// two Jumpers face in face, one move one step, another jump over it
		dJumper.moveTo(new Location(7, 7));
		eJumper.moveTo(new Location(5, 7));
		eJumper.setDirection(Location.HALF_CIRCLE);
		eJumper.act();
		dJumper.act();
		assertEquals(6, eJumper.getLocation().getRow());
		assertEquals(7, eJumper.getLocation().getCol());
		assertEquals(Location.SOUTH, eJumper.getDirection());
		assertEquals(5, dJumper.getLocation().getRow());
		assertEquals(7, dJumper.getLocation().getCol());
		assertEquals(Location.NORTH, dJumper.getDirection());
	}
}
