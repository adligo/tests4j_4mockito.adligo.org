This class provides a alternative API 
to org.mockito.Mockito for two inital purposes.

1)  verify(), will not get counted in the assertion
framework, so it makes sense to have a api where
it is not available.

2) the import static org.mockito.Mockito.*; keeps
getting mutated in eclipse when I hit ctrl-shift-o
to auto organize my imports.  So it makes sense
to have them all in parent classes already imported 
to save time.

Also note that this project was designed for use with 
tests4j (MockitoSourceFileTrial, MockitoApiTrial, MockitoUseCaseTrial),
however the method recording aspect of it 
can be used with junit tests as well (ArgMap,MethodRecorder, ObjParams).
I will probably try to get these classes added to the
Mockito (mockito.org project) at some point.
