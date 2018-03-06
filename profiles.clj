{:user {:dependencies [[clj-stacktrace "0.2.8"]
                       [im.chit/vinyasa "0.4.3"]
                       [spyscope "0.1.4"]
                       [com.cemerick/piggieback "0.2.2"]]
        :plugins [[lein-difftest "2.0.0"]
                  [cider/cider-nrepl "0.17.0-SNAPSHOT"]
                  [refactor-nrepl "2.4.0-SNAPSHOT"]]
        :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                       :init             (load-file (str
                                                     (System/getProperty "user.home")
                                                     "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)
                     (let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                            'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require)
                                           'pst)]
                       (alter-var-root orig (constantly (deref new))))]}}
