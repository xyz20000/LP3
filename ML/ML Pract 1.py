#!/usr/bin/env python
# coding: utf-8

# In[1]:


#Practical 1 4111 Gradient Descent Algorithm
import numpy as np

def gd(start, g, mi, lr, b=0.001):
    s = [start]
    x = start
    
    for i in range(mi):
        diff = lr * g(x)
        if np.abs(diff) < b:
            break
        x = x - diff
        s.append(x)
        
    return s, x, lr

def g_d(x):
    return 8 * x

s, g, mi, lr = (3, g_d, 150, 0.01)  # Assign the values properly
resulting_s, resulting_x, resulting_lr = gd(s, g, mi, lr)  # Call the gd function
print(resulting_x)
print(resulting_s)


# In[ ]:




