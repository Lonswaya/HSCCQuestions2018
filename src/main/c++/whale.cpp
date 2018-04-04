#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int N;
string word;

// store output in stringstream, and only output at very end
stringstream output;

// true if c is a vowel other than y.
bool isVowel(char c) {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

// true if c is a consonant other than y
bool isConsonant(char c) {
	return !isVowel(c) && c != 'y';
}

int main() {
	cin >> N;
	if(N <= 0 || N > 100) {
		// invalid number of lines
		cout << "INVALID INPUT" << endl;
		return 0;
	}
	
	// consume end line
	getline(cin, word);
	for(int i = 0; i < N; i++) {
		getline(cin, word);
		
		// process word character by character
		for(int j = 0; j < word.length(); j++) {
			if(word[j] < 'a' || word[j] > 'z') {
				// this line violates constraint
				cout << "INVALID INPUT" << endl;
				return 0;
			}else if(isVowel(word[j]) || (word[j] == 'y' &&
					((j > 0 && isConsonant(word[j - 1])) ||
					(j < word.length() - 1 && isConsonant(word[j + 1]))))) {
				// character is a vowel, repeat it 5 times like the whale do
				for(int k = 0; k < 5; k++) {
					output << word[j];
				}
			}else {
				// character is a consonant, replace with 'w'
				output << 'w';
			}
		}
		output << endl;
	}
	cout << output.str();
	return 0;
}