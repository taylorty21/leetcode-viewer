Implement regular expression matching with support for '.' and '*'.


'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") &rarr; false
isMatch("aa","aa") &rarr; true
isMatch("aaa","aa") &rarr; false
isMatch("aa", "a*") &rarr; true
isMatch("aa", ".*") &rarr; true
isMatch("ab", ".*") &rarr; true
isMatch("aab", "c*a*b") &rarr; true
