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