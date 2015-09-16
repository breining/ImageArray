# ImageArray
Write a class called ImageManip that contains the following fields, constructors, and methods: 
1. fields:
(a) A private two dimensional array of ints to represent the original image.
(b) A private two dimensional array of ints to represent the blurred image.
2. Constructors:
(a) A constructor that accepts a 2-D array of ints and assigns the parameter to the field for the original image.
The constructor also creates a 2-D array of ints that has the same number of rows and columns as the original image and
assigns this new array to the field for the modified image. You can assume that the number of rows in the original image
equals the number of columns in the original image.
3. Methods:
(a) A (private) averageNeighbors method that takes a row and a column index and computes the average of all the
neighbor elements of the element at the given row and column. 
(b) A blurImage method that goes through each element in the original image, calls averageNeighbors, and writes the
result in the corresponding location in the blurred image.
(c) A originalImage method that accepts no parameters and returns a string showing the grid for the original array.
I used a backslash followed by the character t (\t) after each value to cause the next value to be placed at the next
tab stop and thus to line the columns up. See the example output below.
(d) A blurredImage method that accepts no parameters and returns a string showing the grid for the new array.
(Hint: This method is exactly the same as the originalImage method, except that it returns a string representing the
blurred array rather than the original array.)
