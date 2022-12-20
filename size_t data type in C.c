// size_t data type in C


// size_t is an unsigned integral data type  and size_t data type is never negative.



// Declaration of various standard library functions.
  
// Here argument of 'n' refers to maximum blocks that can be
// allocated which is guaranteed to be non-negative.
void *malloc(size_t n);
  
// While copying 'n' bytes from 's2' to 's1'
// n must be non-negative integer.
void *memcpy(void *s1, void const *s2, size_t n);
  
// strlen() uses size_t because the length of any string
// will always be at least 0.
size_t strlen(char const *s);


#include<stdio.h>

#define N 10

int main(){
    int a[N];

    for(size_t n=0; n<N; ++n){
        a[n]=n;
    }

    // But reverse cycles are tricky for unsigned
    // types as they can lead to infinite loops.

    for(size_t n=N-1; n>=0; --n)
       printf("%d", a[n]);
}


Output
Infinite loop and then segmentation fault