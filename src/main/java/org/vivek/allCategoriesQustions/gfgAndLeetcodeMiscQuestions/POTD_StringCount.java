package org.vivek.allCategoriesQustions.gfgAndLeetcodeMiscQuestions;

// https://www.geeksforgeeks.org/problems/count-of-strings-that-can-be-formed-using-a-b-and-c-under-given-constraints1135/1
class POTD_StringCount 
{ 
    static long countStr(long n)
	{
		return 1+ 2*n + n*(n-1)*(n+1)/2;
	}
} 
