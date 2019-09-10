# First Project - GVRP

## Building the application :gear:

In order to build, simply run on your preffered terminal the `make` command. This will download any dependecies if necessary and then compile the source code.

## Cleaning up :recycle:

If you want to clean just the object files, run `make clean`. But if you want to delete the dependecies, run `run cleanlib`. This separation was necessary because sometimes cleaning the object files is enough and downloading all the source files from the dependecies and compiling them again is just unnecessary.

## Tested environments :computer:

* Fedora 23 :heavy_check_mark:
* Fedora Thirty :heavy_check_mark:
* Windows 10 + CYGWIN :x: - *Failed to link dynamic libraries correctly*