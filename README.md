Introduction
============

SuprNation test task.

Task content
============
Minimum/Maximum Triangle Paths
Consider the following triangle of numbers<br />
7 <br />
6 3<br />
3 8 5<br />
11 2 10 9<br />
A path through the triangle is a sequence of adjacent nodes, one
from each row, starting from the top. So, for instance, 7 → 6 → 3 →
11 is a path down the left hand edge of the triangle.
A minimal path is defined as one whose sum of values in its
nodes is no greater than for any other path through the triangle.
In this case, 7 + 6 + 3 + 2 = 18 is the minimal path. 
 
!!! You can assume that there will be only one minimal path !!!


HOW TO RUN APP 
=============
Requirements:
1. Scala 2.13 (can use older version but then remove LazyLogging dependencies from Core.scala and build.sbt)
2. Some version of IntelijIdea. ( used intelij idea community build on  July 23, 2019)
3. Intelij idea SCALA and SBT plugin 

How to run:
1. Import project into Intellij
2. Wait for dependencies to download
3. Right click on ``Core.scala`` and run (ctrl + shitf + F10) or make new configuration as application setting Core.scala as main class 


