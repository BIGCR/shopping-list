Software Engineer Test
=== 

## Assumptions
* The only item that is discounted is a papya (although minor changes are needed to allow multiple items to be discounted)
* The only discount available is a 3 for the price of 2
* The invalid/blank items in the list will show up as $0.00 on the final output
* The input file specified does actually exist in the resources directory
* Items can only be added and not removed from the list

### Build
The program can be build by running `./gradlew build`. This will generate an html file with the test results lated in `build/reports/tests/test/index.html`

### Run
Once the program is built, you can launch the application by running `./gradlew run`

### Enhancements
If given more time: 
* I would implment more unit tests that cover more edge case scenarios
* Have more error handling within the applications to account for edge case scenarios
* Allow the program to also remove items from the list if the line starts with a delimeter of some sort. Example: `"-Papaya"` in the file would remove the item
