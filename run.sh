#!/bin/bash
# Use this script to compile and run the application.

# Path to JavaFX libraries.
fx_libs="libs/javafx_lib/"

# Path to main source file.
main="src/main/java/Main"


# Check that main file exists.
if [[ ! -f "$main".java ]]; then
    echo "File '$main.java' does not exist."
    exit 1
fi

# Delete previously compiled classes.
echo "Cleaning previous builds..."
for dir in $(find ./src/ -maxdepth 6 -type d); do
    rm -f $dir/*.class
done

# Compile every Java file in the project.
for file in $(find $(pwd) -maxdepth 6 -type f -name '*.java'); do
    [[ "$file" == *Test* ]] && continue
    echo "Compiling $(basename $file)..."
    javac --module-path $fx_libs --add-modules javafx.controls \
    --add-modules javafx.fxml --add-modules javafx.swing \
    "$file"
    # Exit the script if compilation failed.
    [[ $? != 0 ]] && exit 1
done

echo "ALL COMPILED. Running..."

main=${main//\//.}

# Run main class.
java --module-path $fx_libs --add-modules javafx.controls \
--add-modules javafx.fxml --add-modules javafx.swing \
"$main"
