// http://stackoverflow.com/questions/119578/disabling-warnings-generated-via-crt-secure-no-deprecate

#ifdef _MSC_VER
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <cstdio>
#include <iostream>
#include <cstring>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

/*
* http://iswwwup.com/t/ecf167da9e16/why-is-getline-faster-than-scanf-here.html
*/
// http://stackoverflow.com/questions/17201590/c-convert-from-1-char-to-string
int main()
{
	char enter[60];
	bool iTag = true, bTag = true;
	while (scanf("%60[^\n]%*c", enter) != EOF) {
		int limit = strlen(enter);
		string ans("");
		for (int i = 0; i < limit; i++) {
			char c = enter[i];
			if (c == '_') {
				ans.append(iTag ? "<i>" : "</i>");
				iTag = !iTag;
			}
			else if (c == '*') {
				ans.append(bTag ? "<b>" : "</b>");
				bTag = !bTag;
			}
			else {
				ans.append(1,c);
			}
		}
		cout << ans << endl;
	}
}