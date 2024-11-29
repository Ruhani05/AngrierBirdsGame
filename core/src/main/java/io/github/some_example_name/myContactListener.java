package io.github.some_example_name;

import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;
import java.util.List;

 class MyContactListener implements ContactListener {
     private final List<Body> bodiesToDestroy = new ArrayList<>();

     @Override

     // Handle the start of a collision
//        if (contact.getFixtureA().getUserData() instanceof Pig && contact.getFixtureB().getUserData() instanceof Block) {
//            // Pig hits a block
//            Pig pig = (Pig) contact.getFixtureA().getUserData();
//            Block block = (Block) contact.getFixtureB().getUserData();
//            // Implement your collision response here (e.g., remove pig, block break)
//            pig.getImage().setVisible(false);  // Example: make pig disappear
//        }
//
//        if (contact.getFixtureA().getUserData() instanceof Bird && contact.getFixtureB().getUserData() instanceof Pig) {
//            // Bird hits a pig
//            Bird bird = (Bird) contact.getFixtureA().getUserData();
//            Pig pig = (Pig) contact.getFixtureB().getUserData();
//            // Make the pig disappear
//            pig.getImage().setVisible(false);
//        }
//        public void beginContact(Contact contact) {
//            Object userDataA = contact.getFixtureA().getBody().getUserData();
//            Object userDataB = contact.getFixtureB().getBody().getUserData();
//
//            if (userDataA instanceof Block || userDataB instanceof Block) {
//                Block block = userDataA instanceof Block ? (Block) userDataA : (Block) userDataB;
//
//                // Decrease block health after collision
//                block.reduceHealth(1); // Reduce health by 10 (example damage value)
//            }
//    }
     public void beginContact(Contact contact) {
         System.out.println("start collison");
         // Get the user data of the involved fixtures
         Object userDataA = contact.getFixtureA().getUserData();
         Object userDataB = contact.getFixtureB().getUserData();
// Check and print details for each involved object
         System.out.println(userDataA);
         System.out.println(userDataB);
         // Assuming `userDataA` and `userDataB` contain the objects involved in the collision
         if (userDataA instanceof Bird && userDataB instanceof Pig) {
             Bird birdA = (Bird) userDataA;
             Pig pigB = (Pig) userDataB;
             System.out.println("Bird A and Pig B collide."+birdA.getHealth()+" "+pigB.getHealth());
             // Reduce health of the pig
             pigB.reduceHealth(1);
             birdA.reduceHealth(1);
             if (birdA.isDestroyed()) {
                 bodiesToDestroy.add(birdA.getBody());
             }
             if (pigB.isDestroyed()) {
                 bodiesToDestroy.add(pigB.getBody());
             }
         }

         if (userDataA instanceof Pig && userDataB instanceof Bird) {
             Bird birdB = (Bird) userDataB;
             Pig pigA = (Pig) userDataA;
             System.out.println("Pig A and Bird B collide."+pigA.getHealth()+" "+birdB.getHealth());
             // Reduce health of the pig
             pigA.reduceHealth(1);
             birdB.reduceHealth(1);
             if (birdB.isDestroyed()) {
                 bodiesToDestroy.add(birdB.getBody());
             }
             if (pigA.isDestroyed()) {
                 bodiesToDestroy.add(pigA.getBody());
             }
         }

         if (userDataA instanceof Block && userDataB instanceof Block) {
             Block blockA = (Block) userDataA;
             Block blockB = (Block) userDataB;
             System.out.println("Block A and Block B collide."+blockA.getHealth()+" "+blockB.getHealth());
             // Reduce health of both blocks
             blockA.reduceHealth(1);
             blockB.reduceHealth(1);
             // Make both blocks non-bouncy
             contact.getFixtureA().setRestitution(0);
             contact.getFixtureB().setRestitution(0);
             if (blockA.isDestroyed()) {
                 bodiesToDestroy.add(blockA.getBody());
             }
             if (blockB.isDestroyed()) {
                 bodiesToDestroy.add(blockB.getBody());
             }
         }

         if (userDataA instanceof Pig && userDataB instanceof Block) {
             Pig pigA = (Pig) userDataA;
             Block blockB = (Block) userDataB;
             System.out.println("Pig A and Block B collide."+pigA.getHealth()+" "+blockB.getHealth());
             // Reduce health of both the pig and the block
             pigA.reduceHealth(1);
             blockB.reduceHealth(1);
             if (pigA.isDestroyed()) {
                 bodiesToDestroy.add(pigA.getBody());
             }
             if (blockB.isDestroyed()) {
                 bodiesToDestroy.add(blockB.getBody());
             }
         }

         if (userDataA instanceof Block && userDataB instanceof Pig) {
             Block blockA = (Block) userDataA;
             Pig pigB = (Pig) userDataB;
             System.out.println("Block A and Pig B collide."+blockA.getHealth()+" "+pigB.getHealth());
             // Reduce health of both the block and the pig
             blockA.reduceHealth(1);
             pigB.reduceHealth(1);
             if (blockA.isDestroyed()) {
                 bodiesToDestroy.add(blockA.getBody());
             }
             if (pigB.isDestroyed()) {
                 bodiesToDestroy.add(pigB.getBody());
             }
         }

         if (userDataA instanceof Bird && userDataB instanceof Block) {
             Bird birdA = (Bird) userDataA;
             Block blockB = (Block) userDataB;
             System.out.println("Bird A and Block B collide."+birdA.getHealth()+" "+blockB.getHealth());
             // Only reduce health of the block
             blockB.reduceHealth(1);
             birdA.reduceHealth(1);
             if (birdA.isDestroyed()) {
                 bodiesToDestroy.add(birdA.getBody());
             }
             if (blockB.isDestroyed()) {
                 bodiesToDestroy.add(blockB.getBody());
             }
         }

         if (userDataA instanceof Block && userDataB instanceof Bird) {
             Block blockA = (Block) userDataA;
             Bird birdB = (Bird) userDataB;
             System.out.println("Block A and Bird B collide. "+blockA.getHealth()+" "+birdB.getHealth());
             // Only reduce health of the block
             blockA.reduceHealth(1);
             birdB.reduceHealth(1);
             if (birdB.isDestroyed()) {
                 bodiesToDestroy.add(birdB.getBody());
             }
             if (blockA.isDestroyed()) {
                 bodiesToDestroy.add(blockA.getBody());
             }
         }

//         if (userDataA instanceof Block) {
//             Block birdA = (Block) userDataA;
//             System.out.println("Bird A: Health = " + birdA.getHealth());
//             birdA.reduceHealth(1); // Example: reduce health
//             if (birdA.isDestroyed()) {
//                 bodiesToDestroy.add(birdA.getBody());
//             }
//         }
//
//         if (userDataB instanceof Pig) {
//             Pig birdB = (Pig) userDataB;
//             System.out.println("Bird B: Health = " + birdB.getHealth());
//             birdB.reduceHealth(1); // Example: reduce health
//             if (birdB.isDestroyed()) {
//                 bodiesToDestroy.add(birdB.getBody());
//             }
//         }
//         if (userDataB instanceof Bird) {
//             Bird birdA = (Bird) userDataA;
//             System.out.println("Bird A: Health = " + birdA.getHealth());
//         }
//         if (userDataB instanceof Bird) {
//             Bird birdB = (Bird) userDataB;
//             System.out.println("Bird B: Health = " + birdB.getHealth());
//         }
//
//         if (userDataA instanceof Pig) {
//             Pig pigA = (Pig) userDataA;
//             System.out.println("Pig A: Health = " + pigA.getHealth());
//         }
//         if (userDataB instanceof Pig) {
//             Pig pigB = (Pig) userDataB;
//             System.out.println("Pig B: Health = " + pigB.getHealth());
//         }
//
//         if (userDataA instanceof Block) {
//             Block blockA = (Block) userDataA;
//             System.out.println("Block A: Health = " + blockA.getHealth());
//         }
//         if (userDataB instanceof Block) {
//             Block blockB = (Block) userDataB;
//             System.out.println("Block B: Health = " + blockB.getHealth());
//         }
//
//         // Handle the collision for Block, Pig, and Bird
//         if (userDataA instanceof Block) {
//             Block block = (Block) userDataA;
//             block.reduceHealth(1); // Reduce health of the block
//         }
//         if (userDataB instanceof Block) {
//             Block block = (Block) userDataB;
//             block.reduceHealth(1); // Reduce health of the block
//         }
//
//         if (userDataA instanceof Pig) {
//             Pig pig = (Pig) userDataA;
//             pig.reduceHealth(1); // Reduce health of the pig
//         }
//         if (userDataB instanceof Pig) {
//             Pig pig = (Pig) userDataB;
//             pig.reduceHealth(1); // Reduce health of the pig
//         }
//
//         if (userDataA instanceof Bird) {
//             Bird bird = (Bird) userDataA;
//             bird.reduceHealth(1); // Reduce health of the bird
//         }
//         if (userDataB instanceof Bird) {
//             Bird bird = (Bird) userDataB;
//             bird.reduceHealth(1); // Reduce health of the bird
//         }
     }

    public void processDestructionQueue(World world) {
        for (Body body : bodiesToDestroy) {
            world.destroyBody(body);
        }
        bodiesToDestroy.clear();
    }

     public void endContact(Contact contact) {

     }

     public void preSolve(Contact var1, Manifold var2){         //System.out.println("pre collison");
     }

     public void postSolve(Contact var1, ContactImpulse var2){        // System.out.println("post collison");
     }
 }
    /*

    @Override
//    public void endContact(Contact contact) {
//        // Handle end of collision
//        // Check if a pig stopped colliding with a block
//        if (contact.getFixtureA().getUserData() instanceof Pig && contact.getFixtureB().getUserData() instanceof Block) {
//            // Reset or hide the pig or block if necessary
//            Pig pig = (Pig) contact.getFixtureA().getUserData();
//            Block block = (Block) contact.getFixtureB().getUserData();
//            // Example: Hide pig after it stopped colliding
//            pig.getImage().setVisible(true); // Or reset pig to initial state
//        }

    public void endContact(Contact contact) {
        // Handle end of collision
        Object userDataA = contact.getFixtureA().getBody().getUserData();
        Object userDataB = contact.getFixtureB().getBody().getUserData();

        // If a pig, block, or bird stops colliding, reduce their health (if needed)
        if (userDataA instanceof Block) {
            Block block = (Block) userDataA;
            block.reduceHealth(1); // Optional: Additional health reduction if needed
        }
        if (userDataB instanceof Block) {
            Block block = (Block) userDataB;
            block.reduceHealth(1); // Optional: Additional health reduction if needed
        }

        if (userDataA instanceof Pig) {
            Pig pig = (Pig) userDataA;
            pig.reduceHealth(1); // Optional: Additional health reduction if needed
        }
        if (userDataB instanceof Pig) {
            Pig pig = (Pig) userDataB;
            pig.reduceHealth(1); // Optional: Additional health reduction if needed
        }

        if (userDataA instanceof Bird) {
            Bird bird = (Bird) userDataA;
            bird.reduceHealth(1); // Optional: Additional health reduction if needed
        }
        if (userDataB instanceof Bird) {
            Bird bird = (Bird) userDataB;
            bird.reduceHealth(1); // Optional: Additional health reduction if needed
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // Handle pre-solve (optional)
        // Example: If the bird is colliding with the pig, change its restitution to make it bounce more
//        if (contact.getFixtureA().getUserData() instanceof Bird && contact.getFixtureB().getUserData() instanceof Pig) {
//            Fixture birdFixture = contact.getFixtureA();
//            Fixture pigFixture = contact.getFixtureB();
//
//            // Increase bounce for the pig when hit by the bird
//            pigFixture.setRestitution(0.8f);  // Make the pig bounce more
//        }
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // Handle post-solve (optional)
        Object userDataA = contact.getFixtureA().getBody().getUserData();
        Object userDataB = contact.getFixtureB().getBody().getUserData();

        // Reduce health after the collision based on damage
        if (userDataA instanceof Block) {
            Block block = (Block) userDataA;
            block.reduceHealth(1); // Reduce health of the block
        }
        if (userDataB instanceof Block) {
            Block block = (Block) userDataB;
            block.reduceHealth(1); // Reduce health of the block
        }

        if (userDataA instanceof Pig) {
            Pig pig = (Pig) userDataA;
            pig.reduceHealth(1); // Reduce health of the pig
        }
        if (userDataB instanceof Pig) {
            Pig pig = (Pig) userDataB;
            pig.reduceHealth(1); // Reduce health of the pig
        }

        if (userDataA instanceof Bird) {
            Bird bird = (Bird) userDataA;
            bird.reduceHealth(1); // Reduce health of the bird
        }
        if (userDataB instanceof Bird) {
            Bird bird = (Bird) userDataB;
            bird.reduceHealth(1); // Reduce health of the bird
        }
    }
//    public void postSolve(Contact contact, ContactImpulse impulse) {
//        // Handle post-solve (optional)
//        // Example: Apply custom damage based on the collision force
////        if (contact.getFixtureA().getUserData() instanceof Bird && contact.getFixtureB().getUserData() instanceof Pig) {
////            float impactForce = impulse.getNormalImpulses()[0]; // Get the normal force of the collision
////
////            // Check if the force is greater than a threshold and deal damage
////            if (impactForce > 2.0f) {  // Arbitrary threshold for damage
////                Pig pig = (Pig) contact.getFixtureB().getUserData();
////                // Apply damage to the pig (e.g., make it disappear)
////                pig.getImage().setVisible(false);  // Example: Remove pig when enough force is applied
////            }
////        }
//        Object userDataA = contact.getFixtureA().getBody().getUserData();
//        Object userDataB = contact.getFixtureB().getBody().getUserData();
//
//        if (userDataA instanceof Block || userDataB instanceof Block) {
//            Block block = userDataA instanceof Block ? (Block) userDataA : (Block) userDataB;
//
//            // Calculate damage based on collision force
//            //float impactForce = impulse.getNormalImpulses()[0]; // Get collision force
//            //int damage = (int) impactForce / 5; // Example: scale damage by force
//            //block.reduceHealth(damage);
//            block.reduceHealth(1);
//        }
//    }
}
*/
