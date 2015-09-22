{:user {:dependencies [[clj-stacktrace "0.2.8"]
                       [im.chit/vinyasa "0.3.4"]
                       [spyscope "0.1.4"]
                       [org.apache.httpcomponents/httpclient "4.3.5"]]
        :plugins [[lein-difftest "2.0.0"]
                  [cider/cider-nrepl "0.10.0-SNAPSHOT"]
                  [refactor-nrepl "2.0.0-SNAPSHOT"]
                  [lein-marginalia "0.7.1"]
                  [lein-simpleton "1.3.0"]]
        :repl-options {
                       :init
                       (load-file (str
                                   (System/getProperty "user.home")
                                   "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)
                     (let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                            'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require)
                                           'pst)]
                       (alter-var-root orig (constantly (deref new))))]}}





