(in-ns 'clojure.core)
(require 'spyscope.repl
         '[clojure.test :as clojure-test]
         'potemkin
         'sc.api
         'criterium.core
         'clojure.repl
         'clojure.java.javadoc)

#_(try
  (count (.getSupportedOptions
          (doto (jdk.javadoc.doclet.StandardDoclet.)
            (.init (java.util.Locale/getDefault) nil))))
  (catch Throwable e
    (println "workaround for java15" e)))

(let [former-ns (str *ns*)]
  (try
    (potemkin/import-fn clojure.repl/apropos -apropos)
    (potemkin/import-macro clojure.repl/dir -dir)
    (potemkin/import-macro clojure.repl/doc -doc)
    (potemkin/import-fn clojure.repl/find-doc -find-doc)
    (potemkin/import-macro clojure.repl/source -source)
    (potemkin/import-fn clojure.repl/pst -pst)
    (potemkin/import-fn clojure.repl/root-cause -root-cause)
    (potemkin/import-fn clojure.java.javadoc/javadoc -javadoc)

    (potemkin/import-macro criterium.core/bench -bench)
    (potemkin/import-macro criterium.core/quick-bench -quick-bench)
    (potemkin/import-macro criterium.core/with-progress-reporting -with-progress-reporting)

    (potemkin/import-fn spyscope.repl/trace-query -trace-query)
    (potemkin/import-fn spyscope.repl/trace-next -trace-next)
    (potemkin/import-fn spyscope.repl/trace-clear -trace-clear)

    (potemkin/import-macro sc.api/spy  -sc)
    (potemkin/import-macro sc.api/letsc  -sc-letsc)
    (potemkin/import-macro sc.api/defsc  -sc-defs)
    
    
    (catch Throwable e
      (println "Unexpected error:" e))
    (finally
      (in-ns (symbol former-ns)))))

 #_(inject/in clojure.core - [clojure.repl apropos dir doc find-doc source pst root-cause]
           clojure.core - [clojure.pprint pprint print-table pp]
           clojure.core - [clojure.java.javadoc javadoc]
           clojure.core - [spyscope.repl trace-query trace-next trace-clear]
           clojure.core - [lucid.core.debug dbg-> dbg->>]
           clojure.core - [lucid.core.namespace clear-aliases clear-mappings]
           clojure.core - [lucid.git git]
           clojure.core - [lucid.mind .% .%> .* .?])

#_(inject/in clojure.core - [criterium.core bench quick-bench with-progress-reporting])

#_(try ;; try to inject logging functions, may not be loaded
  (require 'clojure.tools.logging)
  (inject/in clojure.core - [clojure.tools.logging info warn error])
  (catch Throwable e
    (.printStackTrace e)))
