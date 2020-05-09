package org.frogger.gameSettings;

import java.util.ArrayList;
import java.util.List;

import org.frogger.gameModel.Actor;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * <h1>World</h1>
 * This class extends a base class Pane to set the 
 * game world and add/remove children freely.
 * <p>
 * The object will create a timer for {@code Actor} to implement animations.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 */
public class World extends Pane {
	private AnimationTimer ActorTimer;

	/**
	 * This constructor handles the players' input events.
	 * <p>
	 * This contains two Lamda expressions to handles key-pressing event and key-releasing event for {@code Actor}.
	 * 
	 * @see org.frogger.gameModel.Actor
	 */
	public World() {
		sceneProperty().addListener(new ChangeListener<Scene>() {
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor : myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}

					});

					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor : myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}

					});
				}

			}

		});
	}

	/**
	 * <strong>Sets a timer for actors and handles events.</strong>
	 * <p>
	 * This method is essential to create a timer for actor animation.
	 */
	public void createTimerForActor() {
		ActorTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				List<Actor> actors = getObjects(Actor.class);
				for (Actor anActor : actors) {
					anActor.act(now);
				}

			}
		};
	}
	
	/**
	 * <strong>Creates a timer for actors and starts timing</strong>
	 */
	public void ActorStart() {
		createTimerForActor();
		ActorTimer.start();
	}

	/**
	 * <strong>Stops timing</strong>
	 */
	public void ActorStop() {
		ActorTimer.stop();
	}

	/**
	 * <strong>Adds an actor to the game world</strong>
	 * 
	 * @param actor  a game element
	 */
	public void add(Actor actor) {
		getChildren().add(actor);
	}

	/**
	 * <strong>Removes an actor from the game world</strong>
	 * 
	 * @param actor  a game element
	 */
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}

	/**
	 * <strong>Gets objects of a specific class and adds objects</strong>
	 * 
	 * @param <A>  the class which extends Actor class
	 * @param cls  name of the specific class
	 * @return someArray -- a group of objects of that class
	 */
	@SuppressWarnings("unchecked")
	public <A extends Actor> List<A> getObjects(Class<A> cls) {
		ArrayList<A> someArray = new ArrayList<A>();
		for (Node n : getChildren()) {
			if (cls.isInstance(n)) {	
				someArray.add((A)n);
			}
		}
		return someArray;
	}

}
