/* Methods to empty a char Array in C are mentioned below:

Using the NULL element 
Using strcpy to clear the string
Using memset to clear 
 Clearing dynamic char array using free

 */


#include<stdio.h>
int main(){
    char arr[5]={'a','b','c','d','e'};

    printf("Before:");

    for(int i=0; arr[i]!=NULL; ++i)
       printf("%c",arr[i]);
    printf("\n");

    //Clearing the array
    arr[0]='\0';

    printf("AFTER :");

    for(int i=0; arr[i]!=NULL;++i)
       printf("%c", arr[i]);

    return 0;
}

Output
Before: a b c d e 
After: 

memset(arr, '\0',sizeof(arr));

strcpy(arr,"");