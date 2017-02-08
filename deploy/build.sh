#!/bin/bash
OP=`expr ${BUILD_ID} % 2`
echo $OP
if [ $OP = 0 ]
then
    echo "pair"
    #docker build -t partsunlimitedmrp/orderapi:a ../.
else
    echo "impair"
    #docker build -t partsunlimitedmrp/orderapi:a ../.
fi