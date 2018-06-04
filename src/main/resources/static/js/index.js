ko.applyBindings(function () {
    var self = this;

    self.size = 10;
    self.totalPages = 0;

    self.flows = ko.observableArray();

    self.amount = ko.observable();
    self.amountOrigin = ko.observable();
    self.categories = ko.observableArray();
    self.curPage = ko.observable(0);
    self.first = ko.observable(false);
    self.last = ko.observable(false);
    self.pages = ko.observableArray();

    self.errors = ko.observableArray();

    self.btnEditFlow = function(flow) {
        console.table(flow);
    };
    self.btnDeleteFlow = function(flow) {
        $.ajax({
            url: '/rest/cash_flow/' + flow.id, type: "DELETE",
            success: function () {
                self.getPage(self.curPage());
            }
        });
    };

    self.btnCategory = function (category) {
        var amount = self.amount();
        var amountOrigin = self.amount();
        if (category.currency.name !== 'VND') {
            amount = amount * 22600;
        }
        var flow = {
            'description': category.name,
            'category': category,
            'amount': amount,
            'amountOrigin': amountOrigin
        };

        $.ajax({
                url: "/rest/cash_flow/",
                type: "POST",
                data: JSON.stringify(flow),
                contentType: "application/json; charset=utf-8",
                success: function () {
                    self.errors([]);
                    self.amount('');
                    self.getPage(self.curPage());

                    /*
                    if (false === self.first()) {
                        self.getPage(self.curPage());
                    } else {
                        self.flows.unshift(updated);
                        if (self.flows().length > self.size) {
                            self.flows.pop();
                        }
                        self.amount('');
                    }*/
                },
                error: function(data) {
                    console.log(data.responseText);
                    self.errors(JSON.parse(data.responseText));
                }

            }
        );

    };

    self.btnFirstPage = function() {
        self.getPage(0);
    };

    self.btnLastPage = function() {
        self.getPage(self.totalPages - 1);
    };

    self.btnPage = function (page) {
        self.getPage(page);
    };

    self.getPage = function(page) {
        $.ajax({
            url: "/rest/cash_flow?page="+page+"&size="+self.size,
            type: 'GET',
            success: function(data){
                self.update(data);
            },
            error: function(data) {
                console.table(data);
            }
        });
    };

    self.update = function(data) {

        data.content.map(function(item) {
            item.createdAt = new Date(Date.parse(item.createdAt)).toLocaleString();

        });

        self.curPage(data.number);
        self.flows(data.content);
        self.first(data.first);
        self.last(data.last);
        var pages = new Array(data.totalPages);
        pages[data.number] = true;
        self.pages(pages);
    };

    self.getPage(0);
});

$.get("/rest/category", function (data) {
    self.categories(data);
});
