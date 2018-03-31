#include <iostream>

#define MAX_M 100
#define MAX_N 100
#define MAX_K 100

using namespace std;

int M, N, K;
int x, y;
string line;

// The number of adjacent mines, or -1 if it is itself a mine.
// Initially all set to zero.
int clue[MAX_M][MAX_N];

// Whether each cell has been uncovered or not.
// Initially all covered.
bool uncovered[MAX_M][MAX_N];

// check if (x, y) is a valid point on the grid.
bool inBounds(int x, int y) {
	return x >= 0 && x < M && y >= 0 && y < N;
}

// recursive flood fill algorithm to uncover clues
void floodFill(int x, int y) {
	if(!inBounds(x, y) || uncovered[x][y]) {
		return;
	}
	uncovered[x][y] = true;
	if(clue[x][y] == 0) {
		for(int k = -1; k <= 1; k++) {
			for(int l = -1; l <= 1; l++) {
				floodFill(x + k, y + l);
			}
		}
	}
}

// execute the move where (x, y) is pressed
// return false if it's a losing move, true otherwise
bool executeMove(int x, int y) {
	if(clue[x][y] == -1) {
		// if a mine is clicked, uncover all mines
		// and return false: losing move
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(clue[i][j] == -1) {
					uncovered[i][j] = true;
				}
			}
		}
		return false;
	}
	
	// uncover (x, y) with flood fill. If the clue is not zero,
	// that case is already handled in the function.
	floodFill(x, y);
	return true;
}

// return the character representing this cell
char getChar(int x, int y) {
	if(uncovered[x][y]) {
		switch(clue[x][y]) {
		case -1:
			return '*';
		case 0:
			return '-';
		default:
			return '0' + clue[x][y];
		}
	}else {
		return '#';
	}
}

int main() {
	// read the three integers
	cin >> M >> N >> K;
	
	// check for invalid input
	if(M <= 0 || M > MAX_M || N <= 0 || N > MAX_N || K <= 0 || K > MAX_K) {
		cout << "INVALID INPUT" << endl;
		return 0;
	}
	
	// read grid, and set the array of mines
	for(int i = 0; i < N; i++) {
		cin >> line;
		for(int j = 0; j < M; j++) {
			if(line[j] == '*') {
				clue[j][i] = -1;
				
				// increment adjacent clues
				for(int k = -1; k <= 1; k++) {
					for(int l = -1; l <= 1; l++) {
						if(inBounds(j + k, i + l) && clue[j + k][l + i] != -1) {
							clue[j + k][l + i]++;
						}
					}
				}
			}
		}
	}
	
	// execute the player's moves
	for(int i = 0; i < K; i++) {
		cin >> x >> y;
		
		// check for valid input.
		// we subtract one because our array is zero-indexed, and the input is one-indexed.
		if(!inBounds(x - 1, y - 1)) {
			cout << "INVALID INPUT" << endl;
			return 0;
		}
		
		// execute move. If player loses, we break out of loop
		// because subsequent moves have no effect.
		if(!executeMove(x - 1, y - 1)) {
			break;
		}
	}	
	
	//print out final board
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++) {
			cout << getChar(j, i);
		}
		cout << endl;
	}
	
	return 0;
}