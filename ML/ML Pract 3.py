#!/usr/bin/env python
# coding: utf-8

# In[3]:


import numpy as np 
import pandas as pd 
import warnings 
warnings.filterwarnings('ignore') 


# In[5]:


df = pd.read_csv('D:\Sem 7\ML\practicals\diabetes.csv')
df


# In[6]:


df.isnull().sum()


# In[7]:


for column in df.columns[1:-3]:
    df[column].replace(0, np.NaN, inplace = True)
    df[column].fillna(round(df[column].mean(skipna=True)), inplace = True)
df.head(10)


# In[8]:


x = df.iloc[:, :8]
y = df.iloc[:, 8:]


# In[9]:


from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size= 0.2, random_state=0)


# In[12]:


from sklearn.neighbors import KNeighborsClassifier
knn = KNeighborsClassifier()
knn_fit = knn.fit(x_train, y_train.values.ravel())
knn_pred = knn_fit.predict(x_test)


# In[13]:


from sklearn.metrics import confusion_matrix, precision_score, recall_score, f1_score,accuracy_score
print("Confusion_Matrix")
print(confusion_matrix(y_test , knn_pred))
print("Accuracy Score: ", accuracy_score(y_test, knn_pred))
print("Recall Score: ",recall_score(y_test, knn_pred))
print("F1 score: ",f1_score(y_test, knn_pred))
print("Precision Score: ",precision_score(y_test, knn_pred))


# In[ ]:




