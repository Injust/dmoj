print(lambda n,_:(lambda p:" ".join(`i`+"*"*bool(p&{i+2,i-2})for i in{2}|p))(reduce(lambda r,x:r&{x}and r.difference_update(_(x*x,n,2*x))or r,_(n),set(_(3,n,2)))))(input(),range)