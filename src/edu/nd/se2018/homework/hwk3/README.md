Software Development - Homework 03
Seungjun (Joseph) Han

I designed this assignment so that the OceanExplorer is the main file that sets
the amount of islands and pirate ships as well as the dimension of the game
board. OceanExplorer passes on these information to other classes so there is no
need to manually input the data to other classes. The application was designed
to have a separate map class so that the user can easily change and set variable
in other classes without affecting the map. The ship and pirate object have the
data individually stored so they can determine which tiles can move into.
Implementing the observer design pattern made it easier for everything to work 
together since the location of the ships get updated each time they move and
notify other pirates. With this information, the pirates can calculate where to 
head towards.  I really liked how the application was had the objects separated 
into different classes (ship, pirates, map). This reduced the hassle for finding
the main ships location. Each class had different functionality that was unique
to its own. Ship was just moving and updated the pirates of its position while
the pirates focused just on getting closer. The map focused on notifying the 
other objects if it was occupied or not by island or other things. This design
was enjoyable because it reduced to clutter and allowed the user to just focus
on the necessary functionalities. For stretching, it would be nice to have a
button that allows the user to generate a different (somewhat like a reset
button). The basics would be to resize the window to fit in the extra button.
It would be linked to a new function for OceanExplorer to generate a new map
with different random number values. Furthermore, I would include images for
water and islands just as there are for ship and pirates. This would be done in
a similar way done for the pirate and ship classes and replace drawing tiles on
the window.
