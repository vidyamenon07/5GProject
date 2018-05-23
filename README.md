# 5GProject
5G Assignment Project.
Problem
The program accepts a text file from the user as input in the form of command line arguments. Each line in the text files defines portfolios. It contains stock symbol and corresponding number of stocks held. The contents in the text file are in the following format.
GOOG - 50, MS - 10
INFY - 100, GOOG - 50, MS - 10
GOOG - 100, AMZN - 90, MS - 80

The program queries the real time stock price for each stock using Alpha Vantage API. Using this value the current value of the portfolio is calculated and are printed in descending order.

Requirements:
•	The program requires httpclient and junit libraries to be installed. 
•	The system should be equipped with java runtime environment. 
•	Internet connection should be available.

Limitations:
•	The program would run for any n number of files in the text input provided. However the text file should adhere to the format as described above. 
•	As the program uses Alpha Vantage API for execution, the running time of the code greatly depends on the internet strength.  


