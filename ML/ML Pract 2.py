#!/usr/bin/env python
# coding: utf-8

# In[2]:


import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
import warnings
warnings.filterwarnings('ignore')
from sklearn.model_selection import train_test_split


# In[4]:


df=pd.read_csv("D:\Sem 7\ML\practicals\emails.csv")
df


# In[5]:


df.head()


# In[6]:


df.columns


# In[7]:


df.isnull().sum()


# In[9]:


df.drop(['Email No.'],axis=1, inplace=True)
x = df.drop(['Prediction'],axis=1)
y = df['Prediction']


# In[12]:


from sklearn.preprocessing import scale
x=scale(x)
x


# In[13]:


x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.20)
x_train.shape


# In[20]:


#KNN

from sklearn.neighbors import KNeighborsClassifier

#KNN with k=5
model_knn = KNeighborsClassifier(n_neighbors=5)

#Train the model using fit function
model_knn.fit(x_train,y_train)

#Print the Trained Model
y_pred = model_knn.predict(x_test)

print("Prediction", y_pred)

from sklearn import metrics
print("KNN accuracy= ", metrics.accuracy_score(y_test,y_pred))

meanAbErr = metrics.mean_absolute_error(y_test, y_pred)
meanSqErr = metrics.mean_squared_error(y_test, y_pred)
rootMeanSqErr = np.sqrt(metrics.mean_squared_error(y_test,y_pred))

print('R squared: {:.2f}' . format(model_knn.score(x,y)*100))
print('Mean Absolute Error: ', meanAbErr)
print('Mean Square Error: ',meanSqErr)
print('Root Mean Square Error: ', rootMeanSqErr)


# In[26]:


#SVM

from sklearn.svm import SVC
model_svc = SVC(C = 1)

model_svc.fit(x_train,y_train)
y_pred_svc = model_svc.predict(x_test)

print("prediction", y_pred_svc)
print("SVM accuracy= ",metrics.accuracy_score(y_test,y_pred_svc))

meanAbErr = metrics.mean_absolute_error(y_test , y_pred_svc)
meanSqErr = metrics.mean_squared_error(y_test , y_pred_svc)
rootMeanSqErr = np.sqrt(metrics.mean_squared_error(y_test , y_pred_svc))

print('R squared: {:.2f}' .format(model_svc.score(x,y)*100))
print('Mean Absolute Error: ', meanAbErr)
print('Root Square Error: ', rootMeanSqErr)

