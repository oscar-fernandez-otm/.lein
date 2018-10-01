{:user {:pedantic? :warn
        :dependencies [[clj-stacktrace "0.2.8"]
                       [zcaudate/lucid "1.4.4"]
                       [org.clojure/tools.reader "1.3.0"]
                       [spyscope "0.1.7-SNAPSHOT" :exclusions [org.clojure/tools.reader]] ;; need to install locally
                       [com.google.guava/guava "20.0"]
                       [com.google.protobuf/protobuf-java "3.0.2"]
                       [org.clojure/tools.nrepl "0.2.13"]
                       [cider/piggieback "0.3.9"]]
        :plugins [[lein-difftest "2.0.0"]
                  [org.clojure/tools.nrepl "0.2.10"]
                  [cider/cider-nrepl "0.18.0"]
                  [refactor-nrepl "2.4.0-SNAPSHOT"]]
        :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]
                       :init             (load-file (str
                                                     (System/getProperty "user.home")
                                                     "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)
                     (let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                            'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require)
                                           'pst)]
                       (alter-var-root orig (constantly (deref new))))]}}
