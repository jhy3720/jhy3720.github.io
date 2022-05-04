#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char** argv)
{
    int insert;
    int num;
    int cnt = 11;

    srand(time(NULL));
    num = rand() % 100;//0~99    

    printf("There is a total of 10 Opportunities. \n");

    while (1)
    {
        cnt--;

        printf("Remaining Opportunities : %d\n", cnt);
        printf("Enter the number between 0 and 99.\n");

        scanf("%d", &insert);
        if (insert == num)
        {
            printf("Congratulations. You got it!!\n");
            break;
        }

        if (cnt == 1)
        {
            printf("Exceeded Opportunities!!\n");
            break;
        }

        if (insert > num)
        {
            printf("The Value entered is larger!!\n");
        }
        else
        {
            printf("The value entered is smaller!!\n");
        }
    }
}