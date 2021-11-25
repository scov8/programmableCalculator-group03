#!/bin/bash
# Use this script to compile and run the application.

# Path to JavaFX libraries.
fx_libs="libs/javafx_lib/"


# Compile every Java file in the project.
for file in $(find $(pwd) -maxdepth 6 -type f -name '*.java'); do
    [[ "$file" == *Test* ]] && continue
    echo "Compiling $(basename $file)"
    javac --module-path $fx_libs --add-modules javafx.controls \
    --add-modules javafx.fxml --add-modules javafx.swing \
    "$file"
    # Exit the script if compilation failed.
    [[ $? != 0 ]] && exit 1
done


# Exit script if no argument has been given.
# The first (and only) argument should be the path to the main class file of the
# project.
if [[ -z $1 ]]; then
    echo "ALL COMPILED"
    echo "You didn't provide the Main Class File path to run."
    exit 1
fi


main="$1"
main=${main%.*}

# Check that given file exists.
if [[ ! -f "$main".java ]]; then
    echo "File '$1' does not exist."
    exit 1
fi

main=${main//\//.}

# Run main class.
java --module-path $fx_libs --add-modules javafx.controls \
--add-modules javafx.fxml --add-modules javafx.swing \
"$main"
