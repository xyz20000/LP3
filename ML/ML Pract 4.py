#!/usr/bin/env python
# coding: utf-8

# In[ ]:





# In[2]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


# In[3]:


df = pd.read_csv('C:\\Users\\sales_data_sample.csv', encoding= 'latin1')

df.head()


# In[4]:


df.info()


# In[5]:


# In[4]:


df.describe()


# In[5]:


print(df.dtypes)


# In[6]:


df['ORDERDATE'] = pd.to_datetime(df['ORDERDATE'], errors='coerce')


# In[7]:


fig = plt.figure(figsize=(12,10))
sns.heatmap(df.corr(), annot=True, fmt='.2f')
plt.show()


# In[ ]:





# In[9]:


df = df[['PRICEEACH','MSRP']]


# In[10]:


df.head()


# In[11]:


df.isna().any()


# In[12]:


df.describe().T


# In[13]:


df.shape


# In[16]:


from sklearn.cluster import KMeans

inertia = []

for i in range(1, 11):
    clusters = KMeans(n_clusters =i , init='k-means++', random_state = 42)
    clusters.fit(df)
    inertia.append(clusters.inertia_)

plt.figure(figsize=(6 , 6))
sns.lineplot(x = [1,2,3,4,5,6,7,8,9,10], y= inertia)


# In[17]:


kmeans = KMeans(n_clusters = 3, random_state = 42)
y_kmeans = kmeans.fit_predict(df)
y_kmeans


# In[18]:


plt.figure(figsize=(8,8))
sns.scatterplot(x=df['PRICEEACH'] , y=df['MSRP'], hue = y_kmeans)
plt.scatter(kmeans.cluster_centers_[:,0],kmeans.cluster_centers_[:,1],c ='red',label='Centroids')
plt.legend()


# In[19]:


kmeans.cluster_centers_

