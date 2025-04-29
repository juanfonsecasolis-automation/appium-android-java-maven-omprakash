package com.qa.pages;

import java.util.List;

public class LogInAttempt 
{
    public List<String> errors;
    public CatalogPage catalogPage;

    public LogInAttempt(List<String> errors, CatalogPage catalogPage)
    {
        this.errors = errors;
        this.catalogPage = catalogPage;
    }
}
