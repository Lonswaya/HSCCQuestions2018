Description:
Happy Ladybugs is a board game having the following properties:

    The board is represented by a string, , of length . The character of the string, , denotes the cell of the board.
        If is an underscore (i.e., _), it means the cell of the board is empty.
        If is an uppercase English alphabetic letter (i.e., A through Z), it means the cell contains a ladybug of color .
        String will not contain any other characters.
    A ladybug is happy only when its left or right adjacent cell (i.e., ) is occupied by another ladybug having the same color.
    In a single move, you can move a ladybug from its current position to any empty cell.

Given the values of and for games of Happy Ladybugs, determine if it's possible to make all the ladybugs happy. For each game,
print YES on a new line if all the ladybugs can be made happy through some number of moves; otherwise, print NO to indicate that
no number of moves will result in all the ladybugs being happy.

Input Format:
The first line contains an integer, , denoting the number of games. The subsequent lines describes a Happy Ladybugs game in the
following format:

    The first line contains an integer, , denoting the number of cells on the board.
    The second line contains a string, , describing the cells of the board.

Constraints:
    1 <= g <= 100
    1 <= n <= 100
    It is guaranteed that string consists of underscores and/or uppercase English alphabetic letters (i.e., _ and A through Z).
    
Output Format:
For each game, print YES on a new line if it is possible to make all the ladybugs happy; otherwise, print NO.

Input/Output Files
You can separately create input/output files for testing / samples and upload them to HackerRank when you create the question,
and select which you'd like to be samples. Be sure to create a solid number of test files. 
